package com.junli.common.utils;

import com.junli.system.entity.Menu;
import com.junli.system.vo.MenuVo;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lijun
 * @create 2017-12-20 11:06
 */
public class MenuUtils {

    public static List<MenuVo> progressMenu(List<Menu> menus) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Map<Boolean, List<Menu>> level = menus.stream().collect(Collectors.partitioningBy(a -> a.getParentId() == 0 ? true : false));
        List<Menu> firstLevel = level.get(true);
        List<Menu> secondLevel = level.get(false);
        List<MenuVo> listVo = new ArrayList<>();
        for (Menu menu : firstLevel) {
            MenuVo menuVo = new MenuVo();
            List<MenuVo> menuVos = new ArrayList<>();
            List<Menu> chlids = secondLevel.stream().filter(secondMenu -> secondMenu.getParentId().equals(menu.getMenuId())).collect(Collectors.toList());
            BeanUtils.copyProperties(menu, menuVo);
            for (Menu menu1:chlids){
                MenuVo menuVo2 = new MenuVo();
                BeanUtils.copyProperties(menu1, menuVo2);
                menuVos.add(menuVo2);
            }
            menuVo.setChilds(menuVos);
            listVo.add(menuVo);
        }
        return listVo;

    }
}
