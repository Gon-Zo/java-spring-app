package com.app.api.service.reivew;

import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.domain.image.ImageRepository;
import com.app.api.domain.product.Product;
import com.app.api.domain.product.ProductRepository;
import com.app.api.domain.review.Review;
import com.app.api.domain.review.ReviewRepository;
import com.app.api.domain.review.Support.ReviewSupport;
import com.app.api.domain.user.User;
import com.app.api.domain.user.UserRepository;
import com.app.api.enums.Types;
import com.app.api.web.dto.ImageResponseDto;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.ReviewResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.app.api.utils.ApiDomainUtils.isNotEmpty;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewSupport support;

    private final ReviewRepository repository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final ImageRepository imageRepository;

    @Override
    public Page<Review> getPageReview(PageableDto dto) {
        return support.findByReview(dto);
    }

    @Override
    public void createReview(ReviewResponseDto dto) {

        User user = userRepository
                .findById(dto.getUserSeq())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND));

        Product product = productRepository
                .findById(dto.getProductSeq())
                .orElseThrow(() -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));

        dto.setUser(user);

        dto.setProduct(product);

        Review review = repository.saveAndFlush(dto.toEntity());

        Long seq = review.getSeq();

        if (isNotEmpty(dto.getImageVals())) {

            dto.getImageVals().stream().forEach(f ->
                            imageRepository.save(
                                    ImageResponseDto.builder()
                                            .dataId(seq)
                                            .photo(f)
                                            .type(Types.review.getValue())
                                            .build()
                                            .toEntity()
                            )
                    );

        }

    }

    @Override
    @Transactional
    public void deleteBy(long seq) {
        repository.deleteById(seq);
    }

    @Override
    public void modifyReview(long seq, ReviewResponseDto dto) {
        support.update(seq, dto);
    }

    @Override
    public Review getReview(long seq) {
        return repository.findById(seq).orElseThrow(() -> new BusinessException(ErrorCode.REVIEW_NOT_FOUND));
    }

}
