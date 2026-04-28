package com.adamchaniago0025.ebrix.data

data class ScanData(
    val id: Int,
    val petak: String,
    val imageBytes: ByteArray?,
    val brix: String,
    val lat: String,
    val lon: String,
    val timestamp: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ScanData

        if (id != other.id) return false
        if (petak != other.petak) return false
        if (imageBytes != null) {
            if (other.imageBytes == null) return false
            if (!imageBytes.contentEquals(other.imageBytes)) return false
        } else if (other.imageBytes != null) return false
        if (brix != other.brix) return false
        if (lat != other.lat) return false
        if (lon != other.lon) return false
        if (timestamp != other.timestamp) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + petak.hashCode()
        result = 31 * result + (imageBytes?.contentHashCode() ?: 0)
        result = 31 * result + brix.hashCode()
        result = 31 * result + lat.hashCode()
        result = 31 * result + lon.hashCode()
        result = 31 * result + timestamp.hashCode()
        return result
    }
}