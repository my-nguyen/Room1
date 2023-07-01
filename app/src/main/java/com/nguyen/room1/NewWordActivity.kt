package com.nguyen.room1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.nguyen.room1.databinding.ActivityNewWordBinding

class NewWordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNewWordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener {
            val intent = Intent()
            if (TextUtils.isEmpty(binding.editWord.text)) {
                setResult(Activity.RESULT_CANCELED, intent)
            } else {
                val word = binding.editWord.text.toString()
                intent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, intent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.nguyen.room1.REPLY"
    }
}