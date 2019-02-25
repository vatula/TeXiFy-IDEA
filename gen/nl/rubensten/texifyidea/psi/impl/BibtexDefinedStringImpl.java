// This is a generated file. Not intended for manual editing.
package nl.rubensten.texifyidea.psi.impl;

import java.util.List;

import com.intellij.psi.PsiReference;
import nl.rubensten.texifyidea.reference.BibtexStringReference;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import static nl.rubensten.texifyidea.psi.BibtexTypes.*;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import nl.rubensten.texifyidea.psi.*;

public class BibtexDefinedStringImpl extends ASTWrapperPsiElement implements BibtexDefinedString {

    public BibtexDefinedStringImpl(ASTNode node) {
        super(node);
    }

    public void accept(@NotNull BibtexVisitor visitor) {
        visitor.visitDefinedString(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof BibtexVisitor) {
            accept((BibtexVisitor)visitor);
        }
        else {
            super.accept(visitor);
        }
    }

    @Override
    public PsiReference getReference() {
        return new BibtexStringReference(this);
    }
}
