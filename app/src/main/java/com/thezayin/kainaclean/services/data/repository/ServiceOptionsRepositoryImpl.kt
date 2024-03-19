package com.thezayin.kainaclean.services.data.repository

import com.thezayin.kainaclean.R
import com.thezayin.kainaclean.services.domain.model.ServiceOptions
import com.thezayin.kainaclean.services.domain.repository.ServiceOptionsRepository
import com.thezayin.kainaclean.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ServiceOptionsRepositoryImpl @Inject constructor() : ServiceOptionsRepository {
    override suspend fun getServiceOptions(): Flow<Response<List<ServiceOptions>>> = flow {
        try {
            emit(Response.Loading)
            val list = listOf(
                ServiceOptions(
                    name = "General Cleaning",
                    icon = R.drawable.ic_cleaning_general,
                    details = "Experience the epitome of cleanliness with our comprehensive general cleaning service. Our expert team meticulously tends to every nook and cranny, leaving your space immaculately clean and refreshed. From dusting and vacuuming to sanitizing surfaces, we go above and beyond to ensure a pristine environment for you to enjoy. Trust us to transform your space into a haven of cleanliness and comfort.",
                    isSelected = false
                ),
                ServiceOptions(
                    name = "Deep Cleaning",
                    icon = R.drawable.ic_cleaning_deep,
                    details =
                    "Indulge in a transformative deep cleaning experience with our specialized service. Delve beyond surface-level cleanliness as our dedicated team meticulously tackles dirt, grime, and buildup in every corner. From meticulously scrubbing floors to disinfecting high-touch areas, we leave no stone unturned in restoring your space to its sparkling best. Elevate your environment with our deep cleaning expertise and revel in a revitalized and sanitized ambiance.",
                    isSelected = false
                ),
                ServiceOptions(
                    name = "Carpet Cleaning",
                    icon = R.drawable.ic_cleaning_carpet,
                    details =
                    "Revitalize your carpets with our professional carpet cleaning service. Say goodbye to stubborn stains and trapped dirt as our skilled technicians employ advanced techniques to restore your carpets' pristine appearance. With meticulous attention to detail, we eliminate deep-seated grime and allergens, leaving your carpets refreshed and rejuvenated. Experience the difference in cleanliness and comfort with our expert carpet cleaning solutions.",
                    isSelected = false
                ),
                ServiceOptions(
                    name = "End of Tenancy Cleaning",
                    icon = R.drawable.ic_cleaning_tenc,
                    details = "Ensure a seamless transition with our End of Tenancy Cleaning service, designed to leave your property immaculate and ready for new occupants. Our expert team meticulously cleans every inch of the space, from top to bottom, ensuring no detail is overlooked. From deep cleaning carpets to sanitizing bathrooms, we restore the property to its original pristine condition. With our thorough and reliable service, you can leave with peace of mind, knowing your former home is left in impeccable condition.",
                    isSelected = false
                ),
                ServiceOptions(
                    name = "Sparkle Cleaning",
                    icon = R.drawable.ic_cleaning_sparkle,
                    details = "Elevate your space to new heights of brilliance with our sparkle cleaning service. Designed to dazzle, our meticulous approach ensures every surface gleams with a radiant shine. From polishing fixtures to wiping down surfaces, we meticulously attend to every detail, leaving your space sparkling and inviting. Experience the magic of sparkle cleaning and step into a world of unparalleled cleanliness and allure.",
                    isSelected = false
                ),
                ServiceOptions(
                    name = "Hostel Cleaning",
                    details =
                    "Experience exceptional cleanliness and comfort with our specialized hostel cleaning service. Tailored to meet the unique needs of hostels, our dedicated team ensures a welcoming and hygienic environment for guests. From thorough room cleaning to meticulous sanitation of common areas, we prioritize cleanliness and guest satisfaction above all else. Trust us to maintain the highest standards of cleanliness, allowing your hostel to shine as a beacon of hospitality and comfort.",
                    icon = R.drawable.ic_cleaning_hostel,
                    isSelected = false
                ),
                ServiceOptions(
                    name = "Kitchen & Oven Deep Cleaning",
                    icon = R.drawable.ic_cleaning_kitchen,
                    details =
                    "Transform your kitchen into a pristine culinary haven with our expert Kitchen & Oven Deep Cleaning service. Our meticulous team dives deep into grease, grime, and baked-on residue to restore your appliances and surfaces to their sparkling best. From degreasing stovetops to scrubbing oven interiors, we leave no corner untouched. Experience the joy of cooking in a spotless kitchen with our thorough and professional deep cleaning solutions.",
                    isSelected = false
                ),
                ServiceOptions(
                    name = "End of Tenancy Cleaning",
                    icon = R.drawable.ic_cleaning_tenc,
                    details = "Ensure a seamless transition with our End of Tenancy Cleaning service, designed to leave your property immaculate and ready for new occupants. Our expert team meticulously cleans every inch of the space, from top to bottom, ensuring no detail is overlooked. From deep cleaning carpets to sanitizing bathrooms, we restore the property to its original pristine condition. With our thorough and reliable service, you can leave with peace of mind, knowing your former home is left in impeccable condition.",
                    isSelected = false
                ),
                ServiceOptions(
                    name = "After Builders Cleaning",
                    icon = R.drawable.ic_cleaning_after_builders,
                    details =
                    "Experience the ultimate transformation with our After Builders Cleaning service, tailored to restore your space to its pre-construction glory. Our meticulous team specializes in tackling the mess left behind after renovations, ensuring every surface shines with pristine cleanliness. From removing construction debris to scrubbing away dust and grime, we leave no trace of the construction process behind. Trust us to bring your space back to life with our comprehensive and efficient cleaning solutions.",
                    isSelected = false
                ),
                ServiceOptions(
                    name = "Hotel & Restaurant Cleaning",
                    icon = R.drawable.ic_cleaning_hotel,
                    details =
                    "Enhance the allure of your establishment with our Hotel & Restaurant Cleaning service, dedicated to maintaining impeccable cleanliness and hygiene standards. Our experienced team meticulously tends to every detail, ensuring a welcoming and sanitized environment for guests and diners alike. From sparkling clean dining areas to pristine guest rooms, we prioritize cleanliness to elevate the overall experience of your hotel or restaurant. Trust us to exceed expectations and leave a lasting impression with our professional cleaning solutions.",
                    isSelected = false
                ),
                ServiceOptions(
                    name = "Gyms & Clubs Cleaning",
                    icon = R.drawable.ic_cleaning_gym,
                    details =
                    "Elevate the standards of cleanliness at your gym or club with our specialized Cleaning service. Our dedicated team is committed to ensuring a pristine and sanitized environment for members to enjoy. From thorough equipment sanitization to meticulous floor cleaning, we prioritize hygiene to create a safe and inviting space for fitness enthusiasts. Experience the difference with our professional cleaning solutions, designed to keep your gym or club in top-notch condition.",
                    isSelected = false
                ),
                ServiceOptions(
                    name = "Schools & Colleges Cleaning",
                    icon = R.drawable.ic_cleaning_school,
                    details =
                    "Promote a healthy and conducive learning environment with our Schools & Colleges Cleaning service. Our dedicated team understands the importance of cleanliness in educational settings and strives to maintain impeccable hygiene standards. From sanitizing classrooms to disinfecting common areas, we prioritize the well-being of students and staff alike. Trust us to create a clean and welcoming atmosphere that fosters academic excellence and student success.",
                    isSelected = false
                ),

                ServiceOptions(
                    name = "Hand Floor Scrubbing",
                    icon = R.drawable.ic_cleaning_hand_scrubing,
                    details =
                    "Restore the gleam to your floors with our Hand Floor Scrubbing service, designed to bring back the shine and luster to any surface. Our skilled technicians use specialized techniques and equipment to gently scrub away dirt, grime, and stains, leaving your floors sparkling clean. Whether it's hardwood, tile, or laminate, we'll give your floors the attention they deserve, ensuring a pristine finish that enhances the overall appearance of your space. Experience the difference with our professional hand floor scrubbing service.",
                    isSelected = false
                ),
            )
            emit(Response.Success(list))

        } catch (e: Exception) {
            emit(Response.Failure(e.localizedMessage ?: "An error occurred"))
        }
    }
}