package br.com.caelum.javace
import java.util.Calendar
import java.math.BigDecimal
//POR FAVOR, NAO OLHE NEM UM COMENTÁRIO, CADA VEZ QUE VOCÊ OLHAR UM PANDA MORRE. LEMBRE-SE NÃO FALTAM MUITOS.
//Classe pequena
case class Evento(nome: String, numeroDeInscricoes: Int, var _valor: BigDecimal = new BigDecimal("100"), id: Long = 10) {
  def valor = _valor
  override def toString = nome + ";" + numeroDeInscricoes + ";" + valor
}
case class Categoria(nome:String)













































object TesteClassePequena extends App {
  val evento = new Evento("JAVACE", 1000, new BigDecimal("100"))
  //acessando um atributo ou um método?
  println(evento.valor)
}

object TesteMetodoSemTipoDeRetornoExplicito extends App {
  val evento = new Evento("JAVACE", 1000, new BigDecimal("100"))
  println(evento.toString)
}

object TesteForeachLista extends App {

  val eventos = List(Evento("JAVACE", 1000, new BigDecimal("100")),
    Evento("Conexao Java", 1000, new BigDecimal("100")),
    Evento("Qcon", 1000, new BigDecimal("100")))
  //quero imprimir as informacoes dos eventos
          eventos.foreach(evento => println(evento))
          eventos.foreach(evento => println)
  //        //ah o underline
          eventos.foreach(println(_))
          eventos.foreach(println)
}

object TesteFold extends App{
  val eventos = List(Evento("JAVACE", 1000, new BigDecimal("100")),
    Evento("Conexao Java", 1000, new BigDecimal("100")),
    Evento("Qcon", 1000, new BigDecimal("100")))
    
  //quero somar o total de pessoas nos eventos, vamos foldar :)
      var total = eventos.foldLeft(0)((cont, evento) => cont + evento.numeroDeInscricoes)
  
      //mas podemos fazer com underline => underscore consulting
      //Consultoria na _ Consulting
      total = eventos.map(_.numeroDeInscricoes).foldLeft(0)(_ + _)
      println(total)
}

object TesteAR extends App {
  val evento = Evento("JAVACE", 1000, new BigDecimal("100"))
  //new EventoAR(evento).save
  //opa, agora eu tenho um metodo save na instancia sem tá nele :).
  evento.save
}

//Qual opção para fazer um if? :)
//Temos vários sabores!!
//Aca
object UsoDaOption extends App {
  val evento = Evento("JAVACE", 1000)
  val possivelCategoria:Option[Categoria] = evento.temCategoria("javace2")
  //e aqui, faço if ou uso o map
  //para quem na manha das maybe monad, fazer isso aqui é natural? ta de sacanagem né? rosto de vitor aqui
  println(possivelCategoria.map(_.nome).getOrElse("Esse evento nao possui essa categoria"))
  if (possivelCategoria.isDefined) {
    println(possivelCategoria.get.nome)
  }

  for (categoria <- possivelCategoria) println(categoria.nome)
}

//Lembrar de fazer a classe sem id
object DuckTyping extends App {
  val evento = Evento("Qcon", 1000, new BigDecimal("100"))
  //DAO generico, aiai? Vamo botar nomes nos bois, DAOUtil  
  new DAOUtil().save(evento)
}

object PegandoOTipoDOGeneric extends App {
  new DAOUtil().all[Evento]
}

//Teste simples usando o switch chique => Pattern Matching né?
//Nem eh o melhor caso, mas é so para mostrar a desconstrução do objeto
object TestePatternMatching extends App {
  val evento = Evento("JAVACE", 500, new BigDecimal("200"))

  evento match {
    case Evento("JAVACE", 500, valor, _) => println("é o javace")
    case Evento("JAVACE", 1000, valor, _) => println("o javace bombou!. Delicia!")
    //case Evento("JAVACE",500,_,_) => "esse javace eh muito barato. Quem nao vei perdeu"
  }
}

object TesteConversaoImplicitaDeParametro extends App {
  implicit def str2BigDecimal(value: String) = new BigDecimal(value)

  //val evento = Evento("JAVACE",500,new BigDecimal("100"))
  val evento = Evento("JAVACE", 500, "100")
}

object TraitsComoContextoParaTestes extends App {
  trait Contexto {
    val delicia = "Olha que bacana"
    val evento = Evento("JAVACE", 500, new BigDecimal("100"))
  }

  //usando o contexto. Lembre no junit vc so pode ter um before mas, de vez em quando, no mesmo cenario vc tem setups de 
  //objetos de maneira distintas

  new Contexto {
    println("Assert =>" + delicia.equals("Olha que bacana"))
  }
}

object VamoTirarOImportDoImplicitONegocioEhMagia extends App{
  //esse aqui é so para lembrar mesmo
}

