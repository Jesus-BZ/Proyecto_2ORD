package org.example.podcast

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.control.Alert
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.stage.Stage
import org.example.podcast.AccesoDatos.PodcastDAOImp

class HelloController {
    @FXML
    private lateinit var welcomeText: Label
    @FXML private lateinit var txtIDPodcast: TextField
    @FXML private lateinit var txtnombre: TextField
    @FXML private lateinit var txtvaloracion: TextField

    private val dao = PodcastDAOImp()

    @FXML
     fun Mostrar (event: ActionEvent){
        try {
            val id = txtIDPodcast.text.toInt()
            val podcartInfo = dao.getPodcastByCodigo(id)

            if (podcartInfo != null ) {
                txtvaloracion.text = "$podcartInfo"
            }else txtnombre.text = "No se encontró el podcast con ID: $id"
        }catch (e:Exception){

            mostrarAlerta("Error","fallo")
        }
     }

    @FXML
    fun cerrarVentana(event: ActionEvent) {
        val nodo = event.source as Node
        val ventana = nodo.scene.window as Stage
        ventana.close()
    }


    private fun mostrarAlerta(titulo: String, contenido: String) {
        val alert = Alert(Alert.AlertType.INFORMATION)
        alert.title = titulo
        alert.contentText = contenido
        alert.showAndWait()
    }




}