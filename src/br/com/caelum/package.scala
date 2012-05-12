package br.com.caelum

package object javace{
  implicit def evento2AR(evento:Evento) = new EventoAR(evento)
}