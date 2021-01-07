package org.csystem.samples.recyclerview

data class Haber(var imageSrcId: Int, var Baslik: String, var author: String) {
    fun changeHaberBaslik(text: String)
    {
        Baslik = text
    }
}