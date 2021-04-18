import ch5.AMT.AMT
import ch5.AST.AST
import ch5.Tokenizer
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream

object Compiler {
    fun getFileCode(mainFile: String): String {
        val inputFilePath = File(mainFile).absolutePath
        val input = BufferedInputStream(FileInputStream(inputFilePath))
        var len = 0
        val temp = ByteArray(1024)
        val sb = StringBuilder()
        while (input.read(temp).also({ len = it }) != -1) sb.append(String(temp, 0, len))
        return sb.toString()
    }

    fun compile(code: String, output: String) {
        val tokenizer = Tokenizer(getFileCode(code))//并没有进行分词
        val ast = AST.parse(tokenizer)
//        ast.print()
        println(ast.static.toString())

        val amt=AMT.parse(ast)

    }
}

fun main() {
    Compiler.compile("src/code/app.ch5", "compile/app.exe")
}