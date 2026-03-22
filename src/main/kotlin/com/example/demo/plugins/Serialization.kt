import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json
import java.math.BigDecimal

object BigDecimalSerializer : kotlinx.serialization.KSerializer<BigDecimal> {
    override val descriptor = kotlinx.serialization.descriptors.PrimitiveSerialDescriptor(
        "BigDecimal", kotlinx.serialization.descriptors.PrimitiveKind.STRING
    )

    override fun serialize(encoder: kotlinx.serialization.encoding.Encoder, value: BigDecimal) {
        encoder.encodeString(value.toPlainString())
    }

    override fun deserialize(decoder: kotlinx.serialization.encoding.Decoder): BigDecimal {
        return BigDecimal(decoder.decodeString())
    }
}

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
}