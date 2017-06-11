/*****************************************************************************
 * Copyright (c) 2013, theborakompanioni (http://www.example.org)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ****************************************************************************/
package rbac.thymeleaf.shiro.processor.element;

import rbac.thymeleaf.shiro.dialect.ShiroFacade;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.element.AbstractConditionalVisibilityElementProcessor;
import org.thymeleaf.util.StringUtils;
import org.thymeleaf.util.Validate;

import static rbac.thymeleaf.shiro.processor.AttributeUtils.getRawValue;

public class HasAllPermissionsElementProcessor extends AbstractConditionalVisibilityElementProcessor {

    public static HasAllPermissionsElementProcessor create() {
        return new HasAllPermissionsElementProcessor();
    }

    private static final String ELEMENT_NAME = "hasallpermissions";
    private static final int PRECEDENCE = 300;

    private static final String DELIMITER = ",";

    protected HasAllPermissionsElementProcessor() {
        super(ELEMENT_NAME);
    }

    @Override
    public int getPrecedence() {
        return PRECEDENCE;
    }

    @Override
    public boolean removeHostElementIfVisible(final Arguments arguments, final Element element) {
        return true;
    }

    @Override
    public boolean isVisible(final Arguments arguments, final Element element) {
        String rawValue = getRawValue(element, "name");

        return ShiroFacade.hasAllPermissions(StringUtils.split(rawValue, DELIMITER));
    }
}