package jp.gcreate.sample.fragmentconstructorsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import jp.gcreate.sample.fragmentconstructorsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var count = 0
    private val fragmentFactory = HasArgumentsFragmentFactory { count }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = fragmentFactory
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.increment.setOnClickListener {
            count++
            replaceFragment()
        }
        binding.decrement.setOnClickListener {
            count--
            replaceFragment()
        }
    }

    private fun replaceFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_2, HasArgumentsFragment::class.java, null)
            .commit()
    }
}
