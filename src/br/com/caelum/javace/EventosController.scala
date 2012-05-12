package br.com.caelum.javace
//import ActiveRecord._
class EventosController(ar:EventoAR) {
  import ar._
  def adiciona(evento:Evento){
    new EventoAR(evento).save
    //lembre-se, esse código vira esse aqui => new ActiveRecord(evento)
    //vc vai ralar para achar uma solução, não acreditem quando falarem no Bolo Pattern
  }
}