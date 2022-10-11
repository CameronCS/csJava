#pragma region Local Include
#include "pch.h"
#include "include/jni.h"
#include "CStream.h"
#include "dllHelper.h"
#pragma endregion

#pragma region Global
#include <iostream>
#include <string>
#include <limits>
#pragma endregion

extern "C" {
	void Java_csjav_CStream_CStream_Cclear(JNIEnv* jvmEnv, jobject CStream) {
		system("cls");
	}

	void Java_csjav_CStream_CStream_CrunCMD(JNIEnv* jvmEnv, jobject Console, jstring CMD) {
		const char* CMD_ = jvmEnv->GetStringUTFChars(CMD, JNI_FALSE);
		system(CMD_);
		jvmEnv->ReleaseStringUTFChars(CMD, CMD_);
	}

	jstring Java_csjav_CStream_CStream_CStrIn(JNIEnv* jvmEnv, jobject CStream, jstring prompt, jboolean newLine) {
		ast::print_prompt(jvmEnv, CStream, prompt, newLine);

		std::string returns;
		std::getline(std::cin, returns, '\n');

		return jvmEnv->NewStringUTF(returns.c_str());
	}

	jboolean Java_csjav_CStream_CStream_CbooleanIn(JNIEnv* jvmEnv, jobject CStream, jstring prompt, jboolean newLine, jchar char_true, jchar char_false, jstring err_fallback) {
		bool* finished = new bool;
		*finished = false;
		jboolean return_value = 0;
		char userIn;
		do {
			*finished = true;
			ast::print_prompt(jvmEnv, CStream, prompt, newLine);

			std::cin >> userIn;
			if (std::cin.fail()) {
				ast::print_prompt(jvmEnv, CStream, err_fallback, JNI_TRUE);
				ios_cls;
				*finished = false;
			}
			
			userIn = toupper(userIn);

			if (userIn == toupper((char)char_true)) {
				return_value = JNI_TRUE;
			} else if (userIn == toupper((char)char_false)) {
				return_value = JNI_FALSE;
			} else {
				ast::print_prompt(jvmEnv, CStream, err_fallback, JNI_TRUE);
				*finished = false;
			}
		} while (*finished == false);
		delete finished;
		return return_value;
	}

	jchar Java_csjav_CStream_CStream_CcharIn(JNIEnv* jvmEnv, jobject CStream, jstring prompt, jboolean newLine) {
		ast::print_prompt(jvmEnv, CStream, prompt, newLine);
		char c;
		std::cin >> c;
		return (jchar)c;
	}

	jint Java_csjav_CStream_CStream_CintIn(JNIEnv* jvmEnv, jobject CStream, jstring prompt, jboolean newLine) {
		ast::print_prompt(jvmEnv, CStream, prompt, newLine);

		long userIn;
		std::cin >> userIn;
		if (std::cin.fail()) {
			ios_cls;
			return (jint)-1;
		}
		return (jint)userIn;
	}

	jlong Java_csjav_CStream_CStream_ClongIn(JNIEnv* jvmEnv, jobject CStream, jstring prompt, jboolean newLine) {
		ast::print_prompt(jvmEnv, CStream, prompt, newLine);

		long long userIn;
		std::cin >> userIn;
		if (std::cin.fail()) {
			ios_cls;
			return (jlong)-1;
		}
		return (jlong)userIn;
	}

	jfloat Java_csjav_CStream_CStream_CfloatIn(JNIEnv* jvmEnv, jobject CStream, jstring prompt, jboolean newLine) {
		ast::print_prompt(jvmEnv, CStream, prompt, newLine);

		float userIn;
		std::cin >> userIn;
		if (std::cin.fail()) {
			ios_cls;
			return (jfloat)-1;
		}
		return (jfloat)userIn;
	}

	jdouble Java_csjav_CStream_CStream_CdoubleIn(JNIEnv* jvmEnv, jobject CStream, jstring prompt, jboolean newLine) {
		ast::print_prompt(jvmEnv, CStream, prompt, newLine);
		double userIn;
		std::cin >> userIn;
		if (std::cin.fail()) {
			ios_cls;
			return (jdouble)-1;
		}
		return (jdouble)userIn;
	}

	void Java_csjav_CStream_CStream_CPrintCharDelay(JNIEnv* jvmEnv, jobject CStream, jstring printStr, jchar dToken, jint dAmount, jboolean newLine) {
		const char* s = jvmEnv->GetStringUTFChars(printStr, JNI_FALSE);
		char delayToken = (char)dToken;
		int delayAmount = (int)dAmount;
		for (int i = 0; i < strlen(s); i++) {
			std::cout << s[i];
			ast::wait(delayToken, delayAmount);
		}
		if (newLine == JNI_TRUE) {
			std::cout << std::endl;
		}
		jvmEnv->ReleaseStringUTFChars(printStr, s);
	}

	void Java_csjav_CStream_CStream_CPrintWordDelay(JNIEnv* jvmEnv, jobject CStream, jobjectArray jstrWords, jchar dToken, jint dAmount, jboolean newLine) {
		int arr_len = jvmEnv->GetArrayLength(jstrWords);
		char delayToken = (char)dToken;
		int delayAmount = (int)dAmount;
		for (int i = 0; i < arr_len; i++) {
			jstring jstr = (jstring)jvmEnv->GetObjectArrayElement(jstrWords, i);;
			const char* s = jvmEnv->GetStringUTFChars(jstr, JNI_FALSE);
			if (strcmp(s, "\n") == 0) {
				std::cout << s;
			} else {
				std::cout << s << " ";
			}
			ast::wait(delayToken, delayAmount);
			jvmEnv->ReleaseStringUTFChars(jstr, s);
		}
		if (newLine == JNI_TRUE) {
			std::cout << std::endl;
		}
	}
}