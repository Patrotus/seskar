package seskar.compiler.union.extensions

import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.compiler.plugin.CompilerPluginRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import seskar.compiler.specialname.extensions.SpecialNameTransformExtension

class UnionRegistrar : CompilerPluginRegistrar() {
    override val supportsK2: Boolean = true

    override fun ExtensionStorage.registerExtensions(
        configuration: CompilerConfiguration,
    ) {
        IrGenerationExtension.registerExtension(SpecialNameTransformExtension())
    }
}
