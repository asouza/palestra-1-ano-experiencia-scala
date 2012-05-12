package br.com.caelum.javace
import java.math.{BigDecimal => JBigDecimal}

//Motivacao para implicit
class EventoAR(evento: Evento) {
  def save {
    println("Salvando o evento => " + evento)
  }
  
  def delete {
    println("Deletando o evento =>"+ evento)
  }
  
  //olha o if retornando. Tem que ser baseado em expressões :).
  def temCategoria(nome:String) = if(nome.toUpperCase == "JAVACE") Some(Categoria(nome)) else None 
  
}

object ActiveRecord {
  //conversao implicita
  implicit def eventoToAR(evento: Evento) = new EventoAR(evento)
}