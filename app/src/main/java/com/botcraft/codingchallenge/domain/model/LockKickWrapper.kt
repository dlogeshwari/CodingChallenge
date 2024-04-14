package com.botcraft.codingchallenge.domain.model


class LockKickWrapper : LockAttribute {
    constructor(primary: LockKick, secondary: LockKick) {
        this.primary = primary
        this.secondary = secondary
    }

    var primary : LockKick = LockKick()
        get() = field                     // getter
        set(value) { field = value }      // setter
    var secondary : LockKick = LockKick()
        get() = field                     // getter
        set(value) { field = value }      // setter
    override val type: Int
        get() = LockAttribute.TYPE_LOCK_KICK
}