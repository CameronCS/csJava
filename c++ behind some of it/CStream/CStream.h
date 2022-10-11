#pragma once
#ifndef __C_IOSTREAM_H__
#define __C_IOSTREAM_H__
#define CSTREAMOUT __declspec(dllexport)
#define SCALL __stdcall

#pragma region  Include
#include "include/jni.h"
#pragma endregion

extern "C" {
	CSTREAMOUT void SCALL Java_csjav_CStream_CStream_Cclear(JNIEnv*, jobject);
	CSTREAMOUT void SCALL Java_csjav_CStream_CStream_CrunCMD(JNIEnv*, jobject, jstring);
	CSTREAMOUT jstring SCALL Java_csjav_CStream_CStream_CStrIn(JNIEnv*, jobject, jstring, jboolean);
	CSTREAMOUT jboolean SCALL Java_csjav_CStream_CStream_CbooleanIn(JNIEnv*, jobject, jstring, jboolean, jchar, jchar,jstring);
	CSTREAMOUT jchar SCALL Java_csjav_CStream_CStream_CcharIn(JNIEnv*, jobject, jstring, jboolean);
	CSTREAMOUT jint SCALL Java_csjav_CStream_CStream_CintIn(JNIEnv*, jobject, jstring, jboolean);
	CSTREAMOUT jlong SCALL Java_csjav_CStream_CStream_ClongIn(JNIEnv*, jobject, jstring, jboolean);
	CSTREAMOUT jfloat SCALL Java_csjav_CStream_CStream_CfloatIn(JNIEnv*, jobject, jstring, jboolean);
	CSTREAMOUT jdouble SCALL Java_csjav_CStream_CStream_CdoubleIn(JNIEnv*, jobject, jstring, jboolean);
	CSTREAMOUT void SCALL Java_csjav_CStream_CStream_CPrintCharDelay(JNIEnv*, jobject, jstring, jchar, jint, jboolean);
	CSTREAMOUT void SCALL Java_csjav_CStream_CStream_CPrintWordDelay(JNIEnv*, jobject, jobjectArray, jchar, jint, jboolean);
}

#endif