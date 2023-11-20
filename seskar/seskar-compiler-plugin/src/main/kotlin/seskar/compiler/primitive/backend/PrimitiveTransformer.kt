package seskar.compiler.primitive.backend

import org.jetbrains.kotlin.backend.common.extensions.IrPluginContext
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.expressions.IrTypeOperator
import org.jetbrains.kotlin.ir.expressions.IrTypeOperator.*
import org.jetbrains.kotlin.ir.expressions.IrTypeOperatorCall
import org.jetbrains.kotlin.ir.expressions.impl.IrCallImpl
import org.jetbrains.kotlin.ir.expressions.impl.IrConstImpl
import org.jetbrains.kotlin.ir.types.getClass
import org.jetbrains.kotlin.ir.util.hasAnnotation
import org.jetbrains.kotlin.ir.visitors.IrElementTransformerVoid
import org.jetbrains.kotlin.name.CallableId
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.Name

private val HAS_TYPE = CallableId(
    packageName = FqName("seskar.js.internal"),
    className = null,
    callableName = Name.identifier("hasType"),
)

private val SUPPORTED_OPERATORS: Set<IrTypeOperator> = setOf(
    INSTANCEOF,
    NOT_INSTANCEOF,

    CAST,
    SAFE_CAST
)

internal class PrimitiveTransformer(
    private val context: IrPluginContext,
) : IrElementTransformerVoid() {
    override fun visitTypeOperator(
        expression: IrTypeOperatorCall,
    ): IrExpression {
        if (expression.operator !in SUPPORTED_OPERATORS)
            return expression

        val primitiveType = expression.typeOperand.getClass()
            ?.takeIf { it.hasAnnotation(JS_PRIMITIVE) }
            ?: return expression

        return hasType(
            argument = expression.argument,
            typeName = primitiveType.name.identifier,
        )
    }

    private fun hasType(
        argument: IrExpression,
        typeName: String,
    ): IrExpression {
        val hasType = context.referenceFunctions(HAS_TYPE).single()

        val call = IrCallImpl.fromSymbolOwner(
            startOffset = argument.startOffset,
            endOffset = argument.endOffset,
            symbol = hasType,
        )

        call.putValueArgument(
            index = 0,
            valueArgument = argument,
        )

        call.putValueArgument(
            index = 1,
            valueArgument = IrConstImpl.string(
                startOffset = argument.startOffset,
                endOffset = argument.endOffset,
                type = context.irBuiltIns.stringType,
                value = typeName,
            )
        )

        return call
    }
}
