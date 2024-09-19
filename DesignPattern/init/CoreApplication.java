package com.sooum.core;

import com.sooum.core.global.init.DataInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
public class CoreApplication implements CommandLineRunner {
    private final DataInitializer dataInitializer;

	@Autowired
    public CoreApplication(DataInitializer dataInitializer) {
        this.dataInitializer = dataInitializer;
    }

    public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
        // 애플리케이션 시작 시 데이터 삽입
		dataInitializer.init();
    }
}

//List<FeedCard> findFeedsByDistance(Point userLocation, Long lastId, double minDist, double maxDist) {
//        Pageable pageRequest = PageRequest.of(0, MAX_PAGE_SIZE);
//        if (lastId.equals(0L)) {
//            return feedCardRepository.findFirstByDistance(userLocation, minDist, maxDist, pageRequest);
//        }
//        return feedCardRepository.findNextByDistance(userLocation, lastId, minDist, maxDist, pageRequest);
//    }


//@Query("SELECT f FROM FeedCard f WHERE St_Distance(f.location, :userLocation) <= :maxDist "
//            + "AND St_Distance(f.location, :userLocation) >= :minDist"
//            + " ORDER BY f.pk DESC")
//    List<FeedCard> findFirstByDistance (@Param("userLocation") Point userLocation, @Param("minDist") double minDist,
//                                        @Param("maxDist") double maxDist, Pageable pageable);
//
//    @Query("SELECT f FROM FeedCard f WHERE St_Distance(f.location, :userLocation) <= :maxDist"
//            + " AND St_Distance(f.location, :userLocation) >= :minDist "
//            + " AND f.pk < :lastId ORDER BY f.pk DESC")
//    List<FeedCard> findNextByDistance(@Param("userLocation") Point userLocation, @Param("lastId") Long lastId,
//                                      @Param("minDist") double minDist, @Param("maxDist") double maxDist, Pageable pageable);





//package com.sooum.core.global.util;
//
//import com.sooum.core.domain.card.controller.DistanceCardController;
//import com.sooum.core.domain.card.controller.LatestFeedController;
//import com.sooum.core.domain.card.dto.DistanceCardDto;
//import com.sooum.core.domain.card.dto.FeedCardDto;
//import com.sooum.core.domain.card.dto.LatestFeedCardDto;
//import org.springframework.hateoas.Link;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//
//import java.util.List;
//
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
//
//public class NextPageLinkGenerator<E extends FeedCardDto> {
//    public Link generateNextPageLink  (List<E> feedCardInfoList) {
//        if (feedCardInfoList.isEmpty()) {
//            return Link.of("Not found");
//        }
//        int lastIdx = feedCardInfoList.size() - 1;
//        long lastCardIdx = feedCardInfoList.get(lastIdx).getId();
//        if (feedCardInfoList.get(0) instanceof LatestFeedCardDto) {
//            return WebMvcLinkBuilder.linkTo(
//                    methodOn(LatestFeedController.class).getClass()
//            ).slash("/latest/"+lastCardIdx).withRel("next");
//        }
//        if (feedCardInfoList.get(0) instanceof DistanceCardDto) {
//            return WebMvcLinkBuilder.linkTo(methodOn(DistanceCardController.class).getClass()
//            ).slash("/"+lastCardIdx).withRel("next");
//        }
//        return Link.of("Not found");
//    }
//
//    public List<E> appendEachCardDetailLink(List<E> feedCardInfoList) {
//        if (feedCardInfoList.isEmpty()) {
//            return feedCardInfoList;
//        }
//        if (feedCardInfoList.get(0) instanceof LatestFeedCardDto) {
//            return feedCardInfoList.stream()
//                    .peek(feedCard -> feedCard.add(WebMvcLinkBuilder.linkTo(LatestFeedController.class)
//                            .slash("/detail/" + feedCard.getId())
//                            .withRel("detail"))).toList();
//        }
//        if (feedCardInfoList.get(0) instanceof DistanceCardDto) {
//            return feedCardInfoList.stream()
//                    .peek(feedCard -> feedCard.add(WebMvcLinkBuilder.linkTo(DistanceCardController.class)
//                            .slash("/" + feedCard.getId())
//                            .withRel("detail"))).toList();
//        }
//        return feedCardInfoList;
//    }
//}


//public static Double calculate(Point cardLocation, Double latitude, Double longitude) {
//        if (latitude == null || longitude == null) {
//            return null;
//        }
//
//        GeometryFactory geometry = new GeometryFactory();
//        Coordinate coordinate = new Coordinate(longitude, latitude);
//        Point targetPoint = geometry.createPoint(coordinate);
//
//        return cardLocation.distance(targetPoint);
//    }