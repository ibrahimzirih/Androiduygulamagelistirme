package com.example.ibogridview

class Sehir {
    var name: String? = null
    var image: Int? = null
    var nufus :Int? = null
    var iklim :Int? = null
    constructor(name: String, image: Int) {
        this.name = name
        this.image = image
    }
    constructor(name: String, image: Int, nufus:Int, iklim:Int) {
        this.name = name
        this.image = image
        this.iklim=iklim
        this.nufus=nufus
    }
    override fun toString(): String {
        return "Sehir(name=$name, image=$image)"
    }
}