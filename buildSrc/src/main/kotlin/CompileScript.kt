import kotlinx.coroutines.runBlocking
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.api.ScriptEvaluationConfiguration
import kotlin.script.experimental.api.onSuccess
import kotlin.script.experimental.api.valueOrThrow
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost

open class CompileScript : DefaultTask() {

    init {
        group = "com.example"
        description = "Compile script"
    }

    @TaskAction
    fun run() {
        runBlocking {
            BasicJvmScriptingHost().run {
                compiler(
                    """
                    println("test")
                    """
                        .trimIndent().toScriptSource(), ScriptCompilationConfiguration.Default
                ).onSuccess {
                    evaluator(it, ScriptEvaluationConfiguration.Default)
                }.valueOrThrow()
            }
        }
    }
}
