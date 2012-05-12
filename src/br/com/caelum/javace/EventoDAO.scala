package br.com.caelum.javace

class EventoDAO {
  //Qual é o retorno?
  def save(evento: Evento) = {
    println("Salvando o evento => " + evento)
    evento
  }
}