package com.botcraft.codingchallenge.domain.model


class LockAngelWrapper : LockAttribute {
    constructor(primary: LockAngle, secondary: LockAngle) {
        this.primary = primary
        this.secondary = secondary
    }

    var primary : LockAngle = LockAngle()
        get() = field                     // getter
        set(value) { field = value }      // setter
    var secondary : LockAngle = LockAngle()
        get() = field                     // getter
        set(value) { field = value }      // setter
    override val type: Int
        get() = LockAttribute.TYPE_LOCK_ANGLE
}