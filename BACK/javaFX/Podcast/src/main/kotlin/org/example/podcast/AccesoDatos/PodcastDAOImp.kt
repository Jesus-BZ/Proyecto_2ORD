package org.example.podcast.AccesoDatos


import org.example.podcast.Negocio.Podcast
import org.example.podcast.Utilidades.SQL_Podcast
import org.example.podcast.Utilidades.conexion

class PodcastDAOImp:PodcastDAO {

    private val conexion = conexion()

    override fun getPodcastByCodigo(codigo: Int): Podcast? {
        conexion.conectar()
        val ps = conexion.getPreparedStatement(SQL_Podcast.SELECT_TITULO_VALORACION_BY_ID)
        ps?.setInt(1, codigo)
        val rs = ps?.executeQuery()
        var podcast:Podcast? = null
        if (rs?.next() == true) {
            podcast = Podcast(rs.getInt("id_podcast"), rs.getString("titulo"), rs.getInt("valoracion"))
        }
        ps?.close()
        conexion.desconectar()
        return podcast

    }




}