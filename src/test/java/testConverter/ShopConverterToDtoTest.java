package testConverter;

import com.amr.project.converter.ShopConverter;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Coupon;
import com.amr.project.model.entity.Shop;
import com.amr.project.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;

public class ShopConverterToDtoTest {

    @Mock
    ShopConverter shopConverter;

    public ShopConverterToDtoTest() {
    }

    @Test
    public void testToDto() throws Exception {

        User testUser = new User();
        testUser.setFirstName("shopConverterTestUser");
        testUser.setId(1L);

        Coupon testCoupon = new Coupon();
        testCoupon.setId(2L);
        List<Coupon> couponList = new ArrayList<>();
        couponList.add(testCoupon);

        Shop testShop = new Shop();
        testShop.setName("testShopName");
        testShop.setUser(testUser);
        testShop.setPhone("testPhone");
        testShop.setCoupons(couponList);
        testShop.setId(3L);

        ShopDto testShopDto = new ShopDto();
        testShopDto.setId(3L);
        testShopDto.setName("testShopName");
        testShopDto.setUserId(1L);
        testShopDto.setPhone("testPhone");
        List<Long> couponIdList = new ArrayList<>();
        couponIdList.add(2L);
        testShopDto.setCouponIds(couponIdList);

        try {
            Assert.assertEquals(testShopDto, shopConverter.toDto(testShop));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
