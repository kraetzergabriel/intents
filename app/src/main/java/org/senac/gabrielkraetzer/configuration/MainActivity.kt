package org.senac.gabrielkraetzer.configuration

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import java.net.URI

class MainActivity : AppCompatActivity() {

    private final val REQUEST_SELECT_CONTACT = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_SELECT_CONTACT &&
                resultCode == Activity.RESULT_OK) {
            val contactURI = data?.data
        }
    }

    fun selectContact() {
        val intent = Intent(Intent.ACTION_PICK).apply {
            type = ContactsContract.Contacts.CONTENT_TYPE
        }

        if (intent.resolveActivity(packageManager)!= null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT)
        }
    }
}
