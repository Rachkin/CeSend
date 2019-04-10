#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_ru_kpnn_dev_cesend_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
