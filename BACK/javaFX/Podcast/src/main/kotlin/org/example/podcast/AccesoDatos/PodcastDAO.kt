package org.example.podcast.AccesoDatos

import org.example.podcast.Negocio.Podcast

interface PodcastDAO {
    fun getPodcastByCodigo(codigo: Int): Podcast?
}