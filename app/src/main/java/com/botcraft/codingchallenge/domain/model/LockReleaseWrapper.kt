package com.botcraft.codingchallenge.domain.model


class LockReleaseWrapper : LockAttribute {
    constructor(primary: LockRelease, secondary: LockRelease) {
        this.primary = primary
        this.secondary = secondary
    }

    var primary : LockRelease = LockRelease()
        get() = field                     // getter
        set(value) { field = value }      // setter
    var secondary : LockRelease = LockRelease()
        get() = field                     // getter
        set(value) { field = value }      // setter
    override val type: Int
        get() = LockAttribute.TYPE_LOCK_RELEASE
}