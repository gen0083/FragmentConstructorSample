package jp.gcreate.sample.fragmentconstructorsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import jp.gcreate.sample.fragmentconstructorsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels { ViewModelProvider.NewInstanceFactory() }
    private val fragmentFactory = HasArgumentsFragmentFactory { vm.countLiveData.value ?: 0 }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = fragmentFactory
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.increment.setOnClickListener {
            vm.increment()
        }
        binding.decrement.setOnClickListener {
            vm.decrement()
        }
        vm.countLiveData.observe(this, Observer {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_2, HasArgumentsFragment::class.java, null)
                .commit()
        })
    }
}
