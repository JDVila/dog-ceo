package dev.jdvila.dogceo.core.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelStoreOwner
import dagger.hilt.android.AndroidEntryPoint
import dev.jdvila.dogceo.core.presentation.ui.Navigation

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ViewModelStoreOwner, LifecycleOwner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContent {
                Navigation(this)
            }
        }

}


