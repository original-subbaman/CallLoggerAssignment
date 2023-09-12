package com.subbaabhishek.callloggerassignment.model

data class CallLog(
    val toPhoneNumber: String,
    val fromPhoneNumber: String,
    val date: String,
    val fileName: String,
    val isIncoming: Boolean,
)
