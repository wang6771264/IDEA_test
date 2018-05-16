import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApplyChangeOrderRequest {

    private Long id;
    private Boolean hasModifyItem;
    private List<ModifyItemDto> modifyItems = new ArrayList<>();
    private Boolean hasModifyDeliveryTime;

    private Date modifyDeliveryTime;

    private String remark;

    @Data
    public static class ModifyItemDto {
        private Long itemId = 1L;                     //lcb_db.pur_single_order_item.id
        private Long fittingPurchaseId = 1L;          //lcb_item_db.it_fitting_purchase.id
        private Long itemContractPrice = 1000L;                      //配件的结算价,销售价
    }

    public void revise(){
        //if(hasModifyItem != null && hasModifyItem){
        //    if (CollectionUtils.isEmpty(modifyItems)) {
        //        throwValidateException("modifyItems is null");
        //    }
        //}
        //
        //if(hasModifyDeliveryTime != null && hasModifyDeliveryTime){
        //    if (modifyDeliveryTime == null) {
        //        throwValidateException("modifyDeliveryTime is null");
        //    }
        //}
    }

    public static void main(String[] args) {
        ModifyItemDto dto = new ModifyItemDto();
        ApplyChangeOrderRequest areq = new ApplyChangeOrderRequest();
        areq.getModifyItems().add(dto);
        System.out.println(JSON.toJSONString(areq, SerializerFeature.WriteMapNullValue));
    }
}
