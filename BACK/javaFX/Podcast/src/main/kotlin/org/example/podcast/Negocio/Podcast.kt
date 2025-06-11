package org.example.podcast.Negocio

class Podcast(var id_podcast:Int ,val  titulo :String,val  valoracion:Int) {
    override fun toString(): String {
        return "Podcast [id_podcast=$id_podcast, titulo=$titulo , valoracion=$valoracion]"
    }

}