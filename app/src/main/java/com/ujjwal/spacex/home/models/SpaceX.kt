package com.ujjwal.spacex.home.models

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class SpaceX(
    @SerializedName("flight_number"           ) var flightNumber          : Int?              = null,
    @SerializedName("mission_name"            ) var missionName           : String?           = null,
    @SerializedName("mission_id"              ) var missionId             : ArrayList<String> = arrayListOf(),
    @SerializedName("launch_year"             ) var launchYear            : String?           = null,
    @SerializedName("launch_date_unix"        ) var launchDateUnix        : Int?              = null,
    @SerializedName("launch_date_utc"         ) var launchDateUtc         : String?           = null,
    @SerializedName("launch_date_local"       ) var launchDateLocal       : String?           = null,
    @SerializedName("is_tentative"            ) var isTentative           : Boolean?          = null,
    @SerializedName("tentative_max_precision" ) var tentativeMaxPrecision : String?           = null,
    @SerializedName("tbd"                     ) var tbd                   : Boolean?          = null,
    @SerializedName("launch_window"           ) var launchWindow          : String?           = null,
    @SerializedName("rocket"                  ) var rocket                : Rocket?           = Rocket(),
    @SerializedName("ships"                   ) var ships                 : ArrayList<String> = arrayListOf(),
    @SerializedName("telemetry"               ) var telemetry             : Telemetry?        = Telemetry(),
    @SerializedName("launch_site"             ) var launchSite            : LaunchSite?       = LaunchSite(),
    @SerializedName("launch_success"          ) var launchSuccess         : String?           = null,
    @SerializedName("links"                   ) var links                 : Links?            = Links(),
    @SerializedName("details"                 ) var details               : String?           = null,
    @SerializedName("upcoming"                ) var upcoming              : Boolean?          = null,
    @SerializedName("static_fire_date_utc"    ) var staticFireDateUtc     : String?           = null,
    @SerializedName("static_fire_date_unix"   ) var staticFireDateUnix    : String?           = null,
   // @SerializedName("timeline"                ) var timeline              : String?           = null,
    //@SerializedName("crew"                    ) var crew                  : String?           = null,
    @SerializedName("last_date_update"        ) var lastDateUpdate        : String?           = null,
    @SerializedName("last_ll_launch_date"     ) var lastLlLaunchDate      : String?           = null,
    @SerializedName("last_ll_update"          ) var lastLlUpdate          : String?           = null,
    @SerializedName("last_wiki_launch_date"   ) var lastWikiLaunchDate    : String?           = null,
    @SerializedName("last_wiki_revision"      ) var lastWikiRevision      : String?           = null,
    @SerializedName("last_wiki_update"        ) var lastWikiUpdate        : String?           = null,
    @SerializedName("launch_date_source"      ) var launchDateSource      : String?           = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        TODO("missionId"),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        TODO("rocket"),
        TODO("ships"),
        TODO("telemetry"),
        TODO("launchSite"),
        parcel.readString(),
        TODO("links"),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(flightNumber)
        parcel.writeString(missionName)
        parcel.writeString(launchYear)
        parcel.writeValue(launchDateUnix)
        parcel.writeString(launchDateUtc)
        parcel.writeString(launchDateLocal)
        parcel.writeValue(isTentative)
        parcel.writeString(tentativeMaxPrecision)
        parcel.writeValue(tbd)
        parcel.writeString(launchWindow)
        parcel.writeString(launchSuccess)
        parcel.writeString(details)
        parcel.writeValue(upcoming)
        parcel.writeString(staticFireDateUtc)
        parcel.writeString(staticFireDateUnix)
        parcel.writeString(lastDateUpdate)
        parcel.writeString(lastLlLaunchDate)
        parcel.writeString(lastLlUpdate)
        parcel.writeString(lastWikiLaunchDate)
        parcel.writeString(lastWikiRevision)
        parcel.writeString(lastWikiUpdate)
        parcel.writeString(launchDateSource)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SpaceX> {
        override fun createFromParcel(parcel: Parcel): SpaceX {
            return SpaceX(parcel)
        }

        override fun newArray(size: Int): Array<SpaceX?> {
            return arrayOfNulls(size)
        }
    }
}

@Keep
data class Rocket (
    @SerializedName("rocket_id"    ) var rocketId    : String?      = null,
    @SerializedName("rocket_name"  ) var rocketName  : String?      = null,
    @SerializedName("rocket_type"  ) var rocketType  : String?      = null,
    @SerializedName("first_stage"  ) var firstStage  : FirstStage?  = FirstStage(),
    @SerializedName("second_stage" ) var secondStage : SecondStage? = SecondStage(),
    @SerializedName("fairings"     ) var fairings    : Fairings?    = Fairings()

)
@Keep
data class Links (

    @SerializedName("mission_patch"       ) var missionPatch      : String?           = null,
    @SerializedName("mission_patch_small" ) var missionPatchSmall : String?           = null,
    @SerializedName("reddit_campaign"     ) var redditCampaign    : String?           = null,
    @SerializedName("reddit_launch"       ) var redditLaunch      : String?           = null,
    @SerializedName("reddit_recovery"     ) var redditRecovery    : String?           = null,
    @SerializedName("reddit_media"        ) var redditMedia       : String?           = null,
    @SerializedName("presskit"            ) var presskit          : String?           = null,
    @SerializedName("article_link"        ) var articleLink       : String?           = null,
    @SerializedName("wikipedia"           ) var wikipedia         : String?           = null,
    @SerializedName("video_link"          ) var videoLink         : String?           = null,
    @SerializedName("youtube_id"          ) var youtubeId         : String?           = null,
    @SerializedName("flickr_images"       ) var flickrImages      : ArrayList<String> = arrayListOf()

)

@Keep
data class LaunchSite (

    @SerializedName("site_id"        ) var siteId       : String? = null,
    @SerializedName("site_name"      ) var siteName     : String? = null,
    @SerializedName("site_name_long" ) var siteNameLong : String? = null

)

@Keep
data class Telemetry (

    @SerializedName("flight_club" ) var flightClub : String? = null

)

@Keep
data class Fairings (

    @SerializedName("reused"           ) var reused          : String? = null,
    @SerializedName("recovery_attempt" ) var recoveryAttempt : String? = null,
    @SerializedName("recovered"        ) var recovered       : String? = null,
    @SerializedName("ship"             ) var ship            : String? = null

)

@Keep
data class SecondStage (

    @SerializedName("block"    ) var block    : Float?                = null,
    @SerializedName("payloads" ) var payloads : ArrayList<Payloads> = arrayListOf()
)

@Keep
data class Payloads (

    @SerializedName("payload_id"       ) var payloadId      : String?           = null,
    @SerializedName("norad_id"         ) var noradId        : ArrayList<String> = arrayListOf(),
    @SerializedName("reused"           ) var reused         : Boolean?          = null,
    @SerializedName("customers"        ) var customers      : ArrayList<String> = arrayListOf(),
    @SerializedName("nationality"      ) var nationality    : String?           = null,
    @SerializedName("manufacturer"     ) var manufacturer   : String?           = null,
    @SerializedName("payload_type"     ) var payloadType    : String?           = null,
    @SerializedName("payload_mass_kg"  ) var payloadMassKg  : String?           = null,
    @SerializedName("payload_mass_lbs" ) var payloadMassLbs : String?           = null,
    @SerializedName("orbit"            ) var orbit          : String?           = null,
    @SerializedName("orbit_params"     ) var orbitParams    : OrbitParams?      = OrbitParams()

)

@Keep
data class OrbitParams (

    @SerializedName("reference_system"   ) var referenceSystem : String? = null,
    @SerializedName("regime"             ) var regime          : String? = null,
    @SerializedName("longitude"          ) var longitude       : String? = null,
    @SerializedName("semi_major_axis_km" ) var semiMajorAxisKm : String? = null,
    @SerializedName("eccentricity"       ) var eccentricity    : String? = null,
    @SerializedName("periapsis_km"       ) var periapsisKm     : String? = null,
    @SerializedName("apoapsis_km"        ) var apoapsisKm      : String? = null,
    @SerializedName("inclination_deg"    ) var inclinationDeg  : String? = null,
    @SerializedName("period_min"         ) var periodMin       : String? = null,
    @SerializedName("lifespan_years"     ) var lifespanYears   : Float?    = null,
    @SerializedName("epoch"              ) var epoch           : String? = null,
    @SerializedName("mean_motion"        ) var meanMotion      : String? = null,
    @SerializedName("raan"               ) var raan            : String? = null,
    @SerializedName("arg_of_pericenter"  ) var argOfPericenter : String? = null,
    @SerializedName("mean_anomaly"       ) var meanAnomaly     : String? = null

)

@Keep
data class Cores (

    @SerializedName("core_serial"     ) var coreSerial     : String? = null,
    @SerializedName("flight"          ) var flight         : String? = null,
    @SerializedName("block"           ) var block          : Float?    = null,
    @SerializedName("gridfins"        ) var gridfins       : String? = null,
    @SerializedName("legs"            ) var legs           : String? = null,
    @SerializedName("reused"          ) var reused         : String? = null,
    @SerializedName("land_success"    ) var landSuccess    : String? = null,
    @SerializedName("landing_intent"  ) var landingIntent  : String? = null,
    @SerializedName("landing_type"    ) var landingType    : String? = null,
    @SerializedName("landing_vehicle" ) var landingVehicle : String? = null

)

@Keep
data class FirstStage (

    @SerializedName("cores" ) var cores : ArrayList<Cores> = arrayListOf()

)
