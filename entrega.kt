// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

enum class Aula(val material: String) {
    VIDEO("video aula"), 
    DES_PROJETO("desafio de projeto"), 
    DES_CODIGO("desafio de código");
}

class Usuario(val nome: String, var senha: Int)

data class ConteudoEducacional(val nome: String, val duracaoHora: Int, val tipo: Aula)

open class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>, val pro: Boolean) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario): Unit {
        if (inscritos.contains(usuario)){
            println("numero de inscritos: ${inscritos.size}") //qtd de matriculados
            inscritos.forEach{println(it.nome)} //nome dos matriculados
            return println("usuario ja cadastrado")
        }
        else{
            inscritos.add(usuario)
        }
    return }
    
    fun descricaoCurso(){
        var duracaoFormacao: Int = 0
        var nomeListaCursos: MutableList<String> = mutableListOf()
        var index: Int = 0
        for (curso in conteudos){ 
            duracaoFormacao += curso.duracaoHora
            nomeListaCursos.add(conteudos.elementAt(index).nome)// jeito mais verboso de se refereir a variavel curso usando index
            index++
        }
        val rowCursos = nomeListaCursos.toString()
        val cursos: String = rowCursos.replace("[", "").replace("]", "") //falta eu conhecer como construir um regex decente, mas a gambiarra ajuda
        println("O curso $nome, tem por $duracaoFormacao horas de duração e você encontrará aulas como $cursos. Para mais informações acesse: www.dio.me . Divirta-se!") 
    }
    fun gratis(){
        if(pro) return println("Curso pago!") else return println("Curso GRATIIIS!!!")
    }
    fun tipoAula(){
        var tipoListaAulas: MutableList<String> = mutableListOf()
        for (curso in conteudos){ 
            tipoListaAulas.add(curso.tipo.material)
        }
        val rowAulas = tipoListaAulas.toString()
        val aulas: String = rowAulas.replace("[", "").replace("]", "")//falta eu conhecer como construir um regex decente, mas a gambiarra ajuda
        return println("Os tipos de aula para $nome são em $aulas.")
    }
}

fun main() {
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
    val f1 = Formacao("Formacão UX Designer", Nivel.INTERMEDIARIO, listOf(c5), true)
    val f2 = Formacao("Formação Unity 3D Game Developer", Nivel.AVANCADO, listOf(c2, c4, c6), true)
    val f3 = Formacao("Kotlin Experience", Nivel.BASICO, listOf(c1, c3), false)
    
    //TESTES
    //f3.matricular(Marcelo)
    //f3.matricular(Ana)
    //f3.matricular(Marcelo)
    
    //f1.descricaoCurso()
    //f2.descricaoCurso()
    //f3.descricaoCurso()
    
    //f2.gratis()
    //f3.gratis()
    
    //f3.tipoAula()
    //f2.tipoAula()
    //f1.tipoAula()
}