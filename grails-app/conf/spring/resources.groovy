import com.ybg.hzt.sys.SystemUserDetailsService
import com.ybg.hzt.sys.UserPasswordEncoderListener

// Place your Spring DSL code here
beans = {
    userDetailsService(SystemUserDetailsService)
    userPasswordEncoderListener(UserPasswordEncoderListener)
}
