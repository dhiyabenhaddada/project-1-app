package com.example.dhiyabh.docway



class Appointment {
    var id: Int = 0
    var namedoctor: String = ""
    var date :String=""

    constructor(namedoctor: String, date: String) {
        this.namedoctor = namedoctor
        this.date = date

    }


    constructor() {
        this.namedoctor = namedoctor
        this.date = date

    }
}