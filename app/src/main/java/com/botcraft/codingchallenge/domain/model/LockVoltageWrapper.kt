package com.botcraft.codingchallenge.domain.model


class LockVoltageWrapper : LockAttribute {
    constructor(primary: LockVoltage, secondary: LockVoltage) {
        this.primary = primary
        this.secondary = secondary
    }

    var primary : LockVoltage = LockVoltage()
        get() = field                     // getter
        set(value) { field = value }      // setter
    var secondary : LockVoltage = LockVoltage()
        get() = field                     // getter
        set(value) { field = value }      // setter
    override val type: Int
        get() = LockAttribute.TYPE_LOCK_VOLTAGE
}