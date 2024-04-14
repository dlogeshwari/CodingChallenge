package com.botcraft.codingchallenge.domain.model


class LockReleaseTimeWrapper : LockAttribute {
    constructor(primary: LockReleaseTime, secondary: LockReleaseTime) {
        this.primary = primary
        this.secondary = secondary
    }

    var primary : LockReleaseTime = LockReleaseTime()
        get() = field                     // getter
        set(value) { field = value }      // setter
    var secondary : LockReleaseTime = LockReleaseTime()
        get() = field                     // getter
        set(value) { field = value }      // setter
    override val type: Int
        get() = LockAttribute.TYPE_LOCK_RELEASE_TIME
}