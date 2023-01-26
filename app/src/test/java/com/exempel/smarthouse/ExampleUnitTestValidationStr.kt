package com.exempel.smarthouse

import com.exempel.smarthouse.data.validation_str.TypeStr
import com.exempel.smarthouse.data.validation_str.ValidationStr
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTestValidationStr {
    @Test
    fun test_email_one_ValidationStr() {
        val v = ValidationStr()
        assertEquals(
            true, v.execute(TypeStr.Email("ga@fa.ef"))
        )
        assertEquals(
            true ,v.execute(TypeStr.Email("wda@j.k.wd"))
        )
    }
    @Test
    fun test_email_two_ValidationStr() {
        val v = ValidationStr()
        assertEquals(
            false, v.execute(TypeStr.Email(""))
        )
        assertEquals(
            false ,v.execute(TypeStr.Email("@."))
        )
    }
    @Test
    fun test_password_one_ValidationStr() {
        val v = ValidationStr()
        assertEquals(
            false, v.execute(TypeStr.Password(""))
        )
        assertEquals(
            false ,v.execute(TypeStr.Password("@."))
        )
    }
    @Test
    fun test_password_two_ValidationStr() {
        val v = ValidationStr()
        assertEquals(
            true, v.execute(TypeStr.Password("123456"))
        )
        assertEquals(
            false, v.execute(TypeStr.Password("12345"))
        )
    }
    @Test
    fun test_username_one_ValidationStr() {
        val v = ValidationStr()
        assertEquals(
            true, v.execute(TypeStr.Username("Олег"))
        )
        assertEquals(
            true, v.execute(TypeStr.Username("Max"))
        )
    }
    @Test
    fun test_username_two_ValidationStr() {
        val v = ValidationStr()
        assertEquals(
            false, v.execute(TypeStr.Username(" Das"))
        )
        assertEquals(
            false, v.execute(TypeStr.Username("1Vasa"))
        )
    }
}