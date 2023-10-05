package com.giaplh.libraryweb.queryfiler.query.util;

import java.util.List;

public class CollectionUtil {

    private CollectionUtil() {}

    public static <P, C extends P> void addChildList(
        List<P> parentList,
        List<C> childList
    ) {
        if (parentList == null) {
            throw new IllegalArgumentException("Parent list can not be null");
        }
        if (childList != null && childList.isEmpty()) {
            parentList.addAll(childList);
        }
    }
}
