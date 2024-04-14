package com.botcraft.codingchallenge.domain.model


class LockTypeWrapper : LockAttribute {
    constructor(primary: LockType, secondary: LockType) {
        this.primary = primary
        this.secondary = secondary
    }

    var primary : LockType = LockType()
        get() = field                     // getter
        set(value) { field = value }      // setter
    var secondary : LockType = LockType()
        get() = field                     // getter
        set(value) { field = value }      // setter
    override val type: Int
        get() = LockAttribute.TYPE_LOCK_TYPE
}