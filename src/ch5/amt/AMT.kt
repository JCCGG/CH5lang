package ch5.amt

import ch5.ast.ASTContainer
import ch5.ast.ASTOuterFun
import ch5.ast.ASTOuterVar

//import ch5.AST.ast_container
object AMT {
    fun parse(ast: ASTContainer): AmtApplication {

        val app = AmtApplication()
        //解析一个静态对象
        val parser=AmtParser()
        app.entryStatic = parser.parseStatic(ast)
        parser.link()
        return app
    }


//    fun parse(ast: ast_container) {
//        val app= amt_application()
//        app.main= amt_container(app,ast)
//        return app
//    }
//    fun parse(app: amt_application, ast:ast_container): amt_container {
//        return amt_container(app,ast)
//    }
}