package org.example.podcast.Utilidades

import java.sql.*

class conexion {
    val url = "jdbc:mysql://localhost/potcast"
    val user = "root"
    val password = ""
    var conn: Connection? = null



    fun conectar() {
        try {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver")
            Class.forName("org.mysql.cj.jdbc.Driver")
            conn = DriverManager.getConnection(url, user, password)
        } catch (e: SQLException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    fun desconectar() {
        try {
            conn?.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun getStatement(): Statement? {
        return conn?.createStatement()
    }

    fun getPreparedStatement(sql: String): PreparedStatement? {
        return conn?.prepareStatement(sql)
    }
}