package br.com.caelum.javace

//Mostrar o manifest e duck typing tipado
class DAOUtil {
  def all[T](implicit manifest: Manifest[T]) {
    println("Listando todo mundo da classe =>" + manifest.erasure)
  }

  //se nao gostou disso aqui, cria um alias
  type Identifiable = { def id: Long }
  def save(obj: Identifiable) {
    println("Salvando o objeto com id sem forçar interface =>" + obj)
  }
}