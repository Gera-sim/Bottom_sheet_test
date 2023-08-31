package com.example.bottom_sheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomSheetContainer = findViewById<LinearLayout>(R.id.bottom_sheet)

        //  BottomSheetBehavior.from() — вспомогательная функция, позволяющая получить объект BottomSheetBehavior, связанный с контейнером BottomSheet
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetContainer).apply {
            state = BottomSheetBehavior.STATE_HIDDEN
        }

        findViewById<Button>(R.id.add).setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
        findViewById<Button>(R.id.btn_confirm).setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            Toast.makeText(this, "Хрень добавлена в корзину", Toast.LENGTH_LONG).show()
            }
        findViewById<Button>(R.id.btn_discard).setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }




        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // newState — новое состояние BottomSheet
                when (newState) {
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        //раскрыт

                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        // дефолт. нераскрыт

                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        // свернут

                    }
                    else -> {
                        // Остальные состояния не обрабатываем
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    }
}