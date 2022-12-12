// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

enum class Aula {VIDEO, DES_PROJETO, DES_CODIGO}

class Usuario(val nome: String, var senha: Int)

data class ConteudoEducacional(val nome: String, val duracaoHora: Int, val tipo: Aula)

open class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>, val pro: Boolean) {

    val inscritos = mutableListOf<Usuario>()
    
    open fun matricular(usuario: Usuario): String {
        TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        if (inscritos.contains(usuario)){
            return "usuario ja cadastrado"
        }
        else{
            inscritos.add(usuario)
        }
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //Usuarios
    val Marcelo = Usuario("Marcelo Vieira", 123456)
    val Ana = Usuario("Ana Maria", 654321)
    val Clara = Usuario("Clara Ester", 153624)
    
    //Conteúdo
    val c1 = ConteudoEducacional("Orientação a Objetos e Tipos de Classes na Prática com Kotlin", 2, Aula.VIDEO)
    val c2 = ConteudoEducacional("Jogo do Balde", 6, Aula.VIDEO)
    val c3 = ConteudoEducacional("Avançando Tecnicamente Com a Expressão When", 1, Aula.DES_CODIGO)
    val c4 = ConteudoEducacional("Velocidade e Gravidade", 1, Aula.DES_PROJETO)
    val c5 = ConteudoEducacional("UI Designer", 4, Aula.VIDEO)
    val c6 = ConteudoEducacional("Criando a Mecânica de Ataque", 8, Aula.DES_CODIGO)
    
    //Formação
    val f1 = Formacao("Formacao UX Designer", Nivel.INTERMEDIARIO, listOf(c5), true)
    val f2 = Formacao("Formação Unity 3D Game Developer", Nivel.AVANCADO, listOf(c2, c4, c6), true)
    val f3 = Formacao("Kotlin Experience", Nivel.BASICO, listOf(c1, c3), false)
    
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
