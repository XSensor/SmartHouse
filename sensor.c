#include "term/src/lzl_Sensor.h"
#include "hardware.h"

JNIEXPORT void JNICALL Java_lzl_Sensor_init(JNIEnv *env, jobject obj){
    init();
}

JNIEXPORT jstring JNICALL Java_lzl_Sensor_get_1humiture
  (JNIEnv *env, jobject obj) {
    int *data = get_wsd(data);
    char temp[100];
    sprintf(temp, "%d.%d", data[2], data[3]);
    int len = strlen(temp);
    temp[len] = ',';
    sprintf(temp+len+1, "%d.%d", data[0], data[1]);
    jstring str = (*env)->NewStringUTF(env, temp);
    return str;
}

JNIEXPORT jstring JNICALL Java_lzl_Sensor_get_1brightness
  (JNIEnv *env, jobject obj) {
    char temp[100];
    float b = get_brightness();
    //printf("bright: %g\n", b);
    sprintf(temp, "%g", b);
    jstring str = (*env)->NewStringUTF(env, temp);
    return str;
}

/*
 * Class:     lzl_Sensor
 * Method:    setLight
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_lzl_Sensor_setLight
  (JNIEnv *env, jobject obj, jstring color) {
    char *col = (char *)(*env)->GetStringUTFChars(env, color, NULL);
    set_light(col);
    (*env)->ReleaseStringUTFChars(env, color, col);
}

/*
 * Class:     lzl_Sensor
 * Method:    setSpeed
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_lzl_Sensor_setSpeed
  (JNIEnv *env, jobject obj, jint speed) {
    set_speed((int)speed);
}

