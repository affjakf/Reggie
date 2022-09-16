package com.yzstu.dto;

import com.yzstu.domain.Setmeal;
import com.yzstu.domain.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
