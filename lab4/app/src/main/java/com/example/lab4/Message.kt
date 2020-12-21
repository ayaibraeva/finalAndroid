package com.example.lab4

class Message {
    private val title: String
    private val sender: String
    private val messageText: String
    constructor( title:String, sender: String, messageText: String){
        this.title = title
        this.sender= sender
        this.messageText = messageText

    }
    fun getTitle (): String = title
    fun getSender(): String = sender
    fun getMessageText(): String = messageText


}